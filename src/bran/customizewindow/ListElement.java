package bran.customizewindow;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public abstract class ListElement {

	public abstract void addTo(DefaultListModel<ListElement> elem);

	public abstract void addTo(ArrayList<Element> elements);

}
