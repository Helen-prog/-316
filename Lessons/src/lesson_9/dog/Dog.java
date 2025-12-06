package lesson_9.dog;

public class Dog {
    String name;
    boolean isCollarPutOn;
    boolean isLeashPutOn;
    boolean isMuzzlePutOn;

    public Dog(String name) {
        this.name = name;
    }

    public void putCollar() {
        System.out.println("Ошейник надет");
        isCollarPutOn = true;
    }

    public void putLeash() {
        System.out.println("Поводок надет");
        isLeashPutOn = true;
    }

    public void putMuzzle() {
        System.out.println("Намордник надет");
        isMuzzlePutOn = true;
    }

    public void walk() throws DogNotReadyException {
        if (isCollarPutOn && isLeashPutOn && isMuzzlePutOn) {
            System.out.println("Идем гулять! " + name + " очень рад!");
        } else {
            throw new DogNotReadyException("Собака " + name + " не готова к прогулке. Проверьте ее экипировку!");
        }
    }
}
