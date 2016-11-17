/**
 * Created by dstepule on 13.09.2016.
 */
public class InnerClassExample {
    public void show() {

    }

    public void hide() {

    }

    public void getAddresses() {

    }

    public void getPeople() {

    }

    public class UIInterface {
        public void show() {
            InnerClassExample.this.show();
        }

        public void hide() {
            InnerClassExample.this.hide();
        }
    }

    public class Data {
        public void getAddress() {
            getAddresses();
        }
    }
}
