package com.learn.demo.abstractQueuedSynchronizer;

import javax.xml.soap.Node;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer{
        static ReentrantReadWriteLock s = new ReentrantReadWriteLock();
        Lock r = s.readLock();
        Lock w = s.writeLock();

        protected boolean isHeldExclusively(){
            r.lock();
            try {
                return getState() == 1;
            }finally {
                r.unlock();
            }
        }

        public boolean tryAcquire(int acquires){
            try {
                w.lock();
                if (compareAndSetState(0,1)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }finally {
                w.unlock();
            }
            return false;
        }

        protected boolean tryRelease(int releases){
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition(){return new ConditionObject();}
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
