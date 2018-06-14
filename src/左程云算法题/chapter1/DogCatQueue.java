package 左程云算法题.chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * p12
 * 猫狗队列-自己创建数据结构
 */

class Pet{
    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getPetType(){
        return this.type;
    }
}

class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}

class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}

class PetEnterQueue{
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getPetEnterType(){
        return this.pet.getPetType();
    }
}

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue(){
        this.catQ = new LinkedList<PetEnterQueue>();
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet){
        if (pet.getPetType().equals("dog"))
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        else if (pet.getPetType().equals("cat"))
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        else
            throw new RuntimeException("error, not dog or cat");
    }

    public Pet pollAll(){
        if (!this.catQ.isEmpty() && !this.dogQ.isEmpty()){
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            }else{
                return this.catQ.poll().getPet();
            }
        }
        else if(!this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }
        else if(!this.catQ.isEmpty()){
            return this.catQ.poll().getPet();
        }
        else{
            throw new RuntimeException("error, queue is empty.");
        }

    }

    public Dog pollDog(){
        if (!this.isDogQueueEmpty()){
            return (Dog) this.dogQ.poll().getPet();
        }else{
            throw new RuntimeException("error, dog queue is empty.");
        }
    }

    public Cat pollCat(){
        if (!this.isCatQueueEmpty()){
            return (Cat) this.catQ.poll().getPet();
        }else{
            throw new RuntimeException("error, cat queue is empty.");
        }
    }

    public boolean isEmpty(){
        return this.catQ.isEmpty() && this.dogQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return this.catQ.isEmpty();
    }

}
