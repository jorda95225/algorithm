package com.jordan.exercise.queue;

/**
 * @autheor masheng
 * @description 猫狗队列
 * @date 2020/4/20
 */
public class PetEnterQueue {
    //原有实例
    private Pet pet;
    //实例的时间戳
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }
}