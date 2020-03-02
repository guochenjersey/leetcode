package org.black.lotus.om.orderbook;

import org.black.lotus.om.order.LimitOrder;
import org.black.lotus.om.order.OrderSide;
import org.black.lotus.om.tick.Tick;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LimitOrderBookImpl<T extends LimitOrder> implements LimitOrderBook<T> {

    private ArrayList<T> buyLimitOrders;
    private ArrayList<T> sellLimitOrders;
    private ReadWriteLock readWriteLock;

    public LimitOrderBookImpl() {
        this.buyLimitOrders = new ArrayList<>();
        this.sellLimitOrders = new ArrayList<>();

        this.readWriteLock = new ReentrantReadWriteLock(true);
    }

    @Override
    public void add(T order) {
        Lock lock = readWriteLock.writeLock();
        try {
            boolean locked = lock.tryLock(5, TimeUnit.SECONDS);
            if (!locked) {
                throw new RuntimeException("Failed to get lock within 5 seconds");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(T order) {
        Lock lock = readWriteLock.writeLock();
        try {
            boolean locked = lock.tryLock(5, TimeUnit.SECONDS);
            if (!locked) {
                throw new RuntimeException("Failed to get lock within 5 seconds");
            }
            if (order.getOrderSide() == OrderSide.BUY) {
                return buyLimitOrders.remove(order);
            } else {
                return sellLimitOrders.remove(order);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public List<T> handle(Tick tick) {
        Lock readLock = readWriteLock.readLock();
        try {
            boolean locked = readLock.tryLock(5, TimeUnit.SECONDS);
            if (!locked) {
                throw new RuntimeException("Failed to get read lock within 5 seconds");
            }
            return null;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int size() {
        Lock readLock = readWriteLock.readLock();
        try {
            boolean locked = readLock.tryLock(5, TimeUnit.SECONDS);
            if (!locked) {
                throw new RuntimeException("Failed to get lock within 5 seconds");
            }

            return 1;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }
    }
}
