package com.jordan.exercise.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @autheor masheng
 * @description 猫狗队列
 * @date 2020/4/20
 */
public class DogCatQueue {
    //思路：count表示实例进队列的时间，有两个队列，一个只放dog类实例，一个只放cat类实例
    //加入实例时，如果是dog，就盖上时间戳，放入dogQ，cat也对应
    //只弹出dog或cat类的实例时，从队列弹出即可，想按实际顺序弹出时，比较两个队列头的时间戳，谁更早就弹出谁
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    //初始化
    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    //添加
    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("not dog or cat");
        }
    }

    //弹出全部
    public Pet pollAll(){
        //两个队列都不为空
        if (!this.catQ.isEmpty()&&!this.dogQ.isEmpty()){
            //哪个小弹哪个
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            }else{
                return this.catQ.poll().getPet();
            }
        }else if (!this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    //弹出狗
    public Pet pollDog(){
        if (!this.dogQ.isEmpty()){
            return (Dog)this.dogQ.poll().getPet();
        }else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    //弹出猫
    public Pet pollCat(){
        if (!this.catQ.isEmpty()){
            return (Cat)this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("Cat queue is empty");
        }
    }

    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return this.catQ.isEmpty();
    }

}