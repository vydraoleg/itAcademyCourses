package oleg;


interface Animal {
    void eat();
}
// Сюда вставить код  
interface Feline extends Animal {
}


public class HouseCat implements Feline {
    public void eat() {
    }
}

/*
//        1.<div class="AnswerText">
interface Feline extends Animal {
}


//        2.<div class="AnswerText">

interface Feline extends Animal {
    void eat();
}

//        3.<div class="AnswerText">
interface Feline extends Animal {
    void eat() {
    }
}


//4.
interface Feline implements Animal {
}

*/
