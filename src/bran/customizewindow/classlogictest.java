package bran.customizewindow;

public class classlogictest {

	public static void main(String[] args) {
		FadeTransitionIn fti = new FadeTransitionIn(.5);
		System.out.println(fti.getClass() + "\n" + fti.getClass().equals(FadeTransitionIn.class) + "\n" + FadeTransitionIn.class);
	}

}
