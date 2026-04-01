class Outer {

    void showOuter() {
        System.out.println("Inside Outer Class");
    }

    class MemberInner {
        void display() {
            System.out.println("Inside Member Inner Class");
        }
    }

    void localInnerMethod() {
        class LocalInner {
            void show() {
                System.out.println("Inside Local Inner Class");
            }
        }

        LocalInner local = new LocalInner();
        local.show();
    }

    void anonymousInnerMethod() {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Inside Anonymous Inner Class");
            }
        };

        r.run();
    }
}

public class Program7 {
    public static void main(String[] args) {

        Outer obj = new Outer();

        obj.showOuter();

        Outer.MemberInner member = obj.new MemberInner();
        member.display();

        obj.localInnerMethod();

        obj.anonymousInnerMethod();
    }
}