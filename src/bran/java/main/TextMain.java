package bran.java.main;

import bran.java.elements.text.LetterCondition;
import bran.java.elements.text.LetterSize;
public class TextMain {

	private static int size;

	enum Letter {

//		a(() -> Math.max(A.columns.size(), O.columns.size()), (r, c) -> A.condition.condition(r, c) || O.condition.condition(r, c))
		A(() -> 2 * size - 1, (r, c) -> r == Math.abs((c + 1) - size) || (r == size / 2 && (r > (c + 1) - size && r > size - (c + 1)))),
//		A(() -> (size - 1) / 2 * 2 + 1, (r, c) -> r == Math.abs((2 * c - size + 2 * (size - size / 2)) - (((size - 1) / 2 * 2 + 1) - 1))
//											   || r == Math.abs((2 * c - size + 2 * (size - size / 2)) - (((size - 1) / 2 * 2 + 1) - 1)) + 1
//											   || (r == size / 2 && (r > (2 * c + 1) - size && r > size - (2 * c + 1)))),

		B(() -> (int) (size - ((2 * size - size / 2 - 2)) / 2.0 + size / 2), (r, c) -> c == 0 || (c < size / 2 && r == 0) || ((c <= size / 2) && (r == (size - size / 2 - 1) || r == size - 1)) || (c >= size / 2) && ((size - size / 2 - 1) / 2.0 > Math.sqrt(Math.pow(r - (size - size / 2 - 1) / 2.0, 2) + Math.pow(c - size / 2, 2)) && (size - size / 2 - 1) / 2.0 - 1 <= Math.sqrt(Math.pow(r - (size - size / 2 - 1) / 2.0, 2) + Math.pow(c - size / 2, 2))) || (c >= size / 2 + 1) && (size - ((size - size / 2 - 1) + (size - 1)) / 2.0 >= Math.sqrt(Math.pow(r - ((size - size / 2 - 1) + (size - 1)) / 2.0, 2) + Math.pow(c - size / 2 + 1, 2)) && size - ((size - size / 2 - 1) + (size - 1)) / 2.0 - 1 < Math.sqrt(Math.pow(r - ((size - size / 2 - 1) + (size - 1)) / 2.0, 2) + Math.pow(c - size / 2 + 1, 2)))),
		C(() -> (int) (.8 * size), (r, c) -> size / 2.0 > Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)) && size / 2.0 - 1 < Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2))),
		D((r, c) -> c == 0 || ((r == 0 || r == size - 1) && c < size / 2) || c >= size / 2 && ((size / 2 == (size / 2 * 2 - size + 1) + (int) Math.sqrt(Math.pow(r - size / 2 + ((size / 2 * 2 - size + 1) * ((r + 1) * 2 / (size + 1))), 2) + Math.pow(c - size / 2, 2))))),
		E((r, c) -> c == 0 || r == 0 || r == size - 1 || (r == size - size / 2 - 1 && c <= size / 2)),
		F((r, c) -> c == 0 || r == 0 || (r == size - size / 2 - 1 && c <= size / 2)),
		G((r, c) -> (c >= size / 2 && r == size / 2) || (c < .75 * size || r > size / 2) && size / 2.0 > Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)) && size / 2.0 - 1 < Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2))),
		H((r, c) -> r == size - size / 2 - 1 || c == 0 || c == size - 1),
		I(() -> size / 2 * 2 + 1, (r, c) -> c == size / 2 || r == 0 || r == size - 1),
		J((r, c) -> (c == size - 1 && r <= size / 2) || (r > size / 2) && (size / 2.0 > Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)) && size / 2.0 - 1 < Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)))),
		K(() -> size / 2 + 2, (r, c) -> c == 0 || (r - size / 2 == c - 1) || (r - size / 2 == - (c - 1))),
		L(() -> size, (r, c) -> c == 0 || r == size - 1),
		M(() -> (int) (1.5 * size), (r, c) -> ((c == 0 || c == (int) (1.5 * size - 1)) || r == Math.round(1.5 * size / 2.0) - (int) Math.abs(c - (int) (1.5 * size) / 2.0 + .5) - 1)),
		N((r, c) -> (c == 0 || c == size - 1) || r == size - Math.abs(c - size)),
		O((r, c) -> size / 2.0 > Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)) && size / 2.0 - 1 < Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2))),
		P((r, c) -> c == 0),
		Q((r, c) -> (r == c && c >= size / 2.0) || (size / 2.0 > Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)) && size / 2.0 - 1 < Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)))),
		R((r, c) -> c == 0 || (c < size / 2 && (r == 0 || r == (size - size / 2 - 1))) || (c >= size / 2) && ((size - size / 2 - 1) / 2.0 > Math.sqrt(Math.pow(r - (size - size / 2 - 1) / 2.0, 2) + Math.pow(c - size / 2, 2)) && (size - size / 2 - 1) / 2.0 - 1 <= Math.sqrt(Math.pow(r - (size - size / 2 - 1) / 2.0, 2) + Math.pow(c - size / 2, 2))) || ((c >= size / 2) && (r == c))),
//		S(() -> size, (r, c) -> (
//				((size) / 4.0 >= Math.sqrt(Math.pow(r - (((size) / 2 - 1) / 2.0), 2) + .25 * Math.pow(c - (size - 1) / 2.0, 2))
//				&& ((size == 4 || size == 2) || 1 <= (Math.pow((r - (((size) / 2 - 1) / 2.0)) / (size / 4.0 - 1), 2) + Math.pow((c - (size - 1) / 2.0) / (2 * (size / 4.0) - 1), 2)))
//				&& !(c >= size - size / 2 && r > size / 4 && r < size / 2))
//
//				|| 		(
//					(size) / 4.0 >= Math.sqrt(Math.pow(r - (size - 1 - ((size) / 2 - 1) / 2.0), 2) + .25 * Math.pow(c - (size - 1) / 2.0, 2))
//				&& ((size == 4 || size == 2) || 1 <= (Math.pow((r - (size - 1 - ((size) / 2 - 1) / 2.0)) / (size / 4.0 - 1), 2) + Math.pow((c - (size - 1) / 2.0) / (2 * (size / 4.0) - 1), 2)))
//				&& !(c < size / 2 && r >= size / 2 && r < 3 * size / 4)
//						)
//				)),
		S(() -> size, (r, c) -> (
				((size) / 4.0 >= Math.sqrt(Math.pow(r - (((size) / 2 - 1) / 2.0), 2) + .25 * Math.pow(c - (size - 1) / 2.0, 2))
				&& ((size == 4 || size == 2) || 1 <= (Math.pow((r - (((size) / 2 - 1) / 2.0)) / (size / 4.0 - 1), 2) + Math.pow((c - (size - 1) / 2.0) / (2 * (size / 4.0) - 1), 2)))
				&& !(c >= size / 2 && r > size / 4 && r < size / 2))

				|| 		(
					(size) / 4.0 >= Math.sqrt(Math.pow(r - (size - 1 - ((size) / 2 - 1) / 2.0), 2) + .25 * Math.pow(c - (size - 1) / 2.0, 2))
				&& ((size == 4 || size == 2) || 1 <= (Math.pow((r - (size - 1 - ((size) / 2 - 1) / 2.0)) / (size / 4.0 - 1), 2) + Math.pow((c - (size - 1) / 2.0) / (2 * (size / 4.0) - 1), 2)))
				&& !(c < size / 2 + ((size + 1) / 2 - size / 2) && r >= size / 2 && r < 3 * size / 4)
						)
				||
					((size / 2 != size / 2.0) && r == c && r == size / 2)
				)),
//		((size + 1) / 2 - size / 2) / 2.0			size - 1 - for bottom
//		S(() -> size, (r, c) -> (size / 4.0 > Math.sqrt(Math.pow(r - size /4, 2) + .25 * Math.pow(c - size / 2, 2)) && size / 4.0 - 1 < Math.sqrt(Math.pow(r - size / 4, 2) + .25 * Math.pow(c - size / 2, 2)))
//				|| (size / 4.0 >= Math.sqrt(Math.pow(r - size * 3 / 4, 2) + .25 * Math.pow(c - size / 2, 2)) && size / 4.0 - 1 <= Math.sqrt(Math.pow(r - size * 3 / 4, 2) + .25 * Math.pow(c - size / 2, 2)))),
		T(() -> size / 2 * 2 + 1, (r, c) -> c == size / 2 || r == 0),
		U((r, c) -> ((c == 0 || c == size - 1) && r <= size / 2) || (r > size / 2) && (size / 2.0 > Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)) && size / 2.0 - 1 < Math.sqrt(Math.pow(r - (size - 1) / 2.0, 2) + Math.pow(c - (size - 1) / 2.0, 2)))),
		V(() -> 2 * size + 1, (r, c) -> r == size - Math.abs(c - size) - 1),
		W(() -> (int) (1.5 * size), (r, c) -> ((c == 0 || c == (int) (1.5 * size - 1)) || r == size - Math.round(1.5 * size / 2.0) + (int) Math.abs(c - (int) (1.5 * size) / 2.0 + .5))),
		X((r, c) -> r == c || r == (size - 1) - c),
		Y(() -> size / 2 * 2 + 1, (r, c) -> (c == size / 2 && r >= size / 2) || r == Math.round(size / 2) - (int) Math.abs(c - (size / 2))),
		Z((r, c) -> r == 0 || r == size - 1 || r == (size - 1) - c),
//		a(() -> A.columns.size() + O.columns.size() - 2, (r, c) -> A.condition.condition(r, c) || O.condition.condition(r, c - A.columns.size() + 2)),
		
		tab(() -> 5 * size, (r, c) -> true), // tab("\t, () -> size, (r, c) -> true),
		exclamation_mark("!", () -> 1, (r, c) -> r != size - size / 5 - 1),
		apostrophe("'", () -> 1, (r, c) -> r == 0 || r == 1),
		comma(",", () -> 1, (r, c) -> r == size - 1 || r == size - 2),
		hyphen("-", (r, c) -> r == size / 2),
		period(".", () -> 1, (r, c) -> r == size - 1),
		slash("/", (r, c) -> r == (size - 1) - c),
		colon(() -> 1, (r, c) -> r == size - 1 || r == 1),
		question_mark((r, c) ->  ((size) / 4.0 >= Math.sqrt(Math.pow(r - (((size) / 2 - 1) / 2.0), 2) + .25 * Math.pow(c - (size - 1) / 2.0, 2)) && ((size == 4 || size == 2) || 1 <= (Math.pow((r - (((size) / 2 - 1) / 2.0)) / (size / 4.0 - 1), 2) + Math.pow((c - (size - 1) / 2.0) / (2 * (size / 4.0) - 1), 2))) && !(c <= size / 2 && r > size / 4 && r < size / 2)) || c == size / 2 && (r >= size / 2 && r <= 3 * size / 4 || r == size - 1)),
		backslash("\\", (r, c) -> r == c),
		space(" ", () -> size, (r, c) -> true), //V and A to change slope ?
		
//		zero_width_space(() -> 0, (r, c) -> false),
		invalid_character(String.valueOf((char) 16), () -> size, (r, c) -> true),
		
		;
//		TODO m and w at size 2 are upside down?
		private LetterSize columns;
		private LetterCondition condition;
		private String value;
//		private final LetterCondition range = (r, c) -> r >= 0 && r <= size - 1 && c >= 0 && c <= columns.size();
		private final LetterCondition range = (r, c) -> true;

		private Letter(LetterCondition condition) {
			this.columns = () -> size;
//			this.condition = (r, c) -> condition.condition(r, c) && range.condition(r, c);
			this.condition = condition;
			this.value = this.name();
		}

		private Letter(LetterSize columns, LetterCondition condition) {
			this.columns = columns;
			this.condition = condition;
			this.value = this.name();
		}
		
		private Letter(String value, LetterSize columns, LetterCondition condition) {
			this.columns = columns;
			this.condition = condition;
			this.value = value;
		}
		
		private Letter(String value, LetterCondition condition) {
			this.columns = () -> size;
			this.condition = condition;
			this.value = value;
		}
		
//		public String getName() {
//			switch(this) {
//			case tab : return "\t";
//			case exclamation_point : return "!";
//			case period : return ".";
//			case backslash : return "\\";
//			case slash : return "/";
//			case invalid_character : return String.valueOf((char) 16);
//			default : return name();
//			}
//		}
	}

//	private static String consistent;

	public static void main(String[] args) {

//		consistent = "";

//		String all = "E ";
//		for (Letter x : Letter.values())
//			all += x.value;

		for (int i = 1; i <= 17; i++) {
			size = i;
			System.out.println(i + "" + "" + "\n" + getText("abgua", false, false));
		}

//		size = 5;
//
//		System.out.println(getText("", false, false));



	}

	public static String getText(String str, boolean bold, boolean italicized) { //puts together all the letters

		if (size == 0)
			return "";

		if (size == 1)
			return str;

		int boldIntensity = 0;
		if (bold)
			boldIntensity = 1;

		String[] lines = str.split("\n");

		Letter[][] letters = new Letter[lines.length][];
		int[][] distances = new int[lines.length][];

		for (int lns = 0; lns < lines.length; lns++) {
			letters[lns] = new Letter[lines[lns].length()];
			distances[lns] = new int[lines[lns].length()]; //TODO potential error if the line has length 0
		}

		for (int r = 0; r < letters.length; r++)
			for (int i = 0; i < letters[r].length; i++) {
				switch(lines[r].codePointAt(i)) {
				case 9: // \t
					letters[r][i] = Letter.tab;
					break;
				case 33:
					letters[r][i] = Letter.exclamation_mark;
					break;
				case 34: // \"
//					letters[r][i] = Letter.quotation; break;
				case 39:
					letters[r][i] = Letter.apostrophe;
					break;
				case 44:
					letters[r][i] = Letter.comma;
					break;
				case 45:
					letters[r][i] = Letter.hyphen;
					break;
				case 46:
					letters[r][i] = Letter.period;
					break;
				case 47: // /
					letters[r][i] = Letter.slash;
					break;
				case 58: // /
					letters[r][i] = Letter.colon;
					break;
				case 63: // /
					letters[r][i] = Letter.question_mark;
					break;
				case 92: // \\
					letters[r][i] = Letter.backslash;
					break;
				case ' ':
					letters[r][i] = Letter.space;
					break;
				default :
					try {
						letters[r][i] = Letter.valueOf(lines[r].substring(i, i + 1));
					}
					catch (IllegalArgumentException ex) {
						letters[r][i] = Letter.invalid_character;
					}
					break;
				}
			}

		String space = "";
			for (int s = 0; s < size / 3; s++)
				space += " ";
		String lineGap = "";
		for (int s = 0; s < size / 3; s++)
			lineGap += "\n";

		for (int line = 0; line < letters.length; line++) {//line
			distances[line][0] = 0;
//			distances[line][0] = 0;
//			distances[line][distances[line].length - 1] = 0;

		for (int letter = 0; letter < letters[line].length - 1; letter++) { //letter
				int[] letterDistances = new int[size];
				if (letters[line][letter].equals(Letter.space) || letters[line][letter + 1].equals(Letter.space) ||
					letters[line][letter].equals(Letter.tab) || letters[line][letter + 1].equals(Letter.tab))
					distances[line][letter + 1] = 0;
//				else if (letters[line][letter].columns.size() == 1)
//					distances[line][letter + 1] = 0;
//				else if (letters[line][letter + 1].columns.size() == 1)
//					distances[line][letter + 1] = 0;
				else {
					for (int r = 0; r < size; r++) {
						int leftSpaceCount = 0;
						int rightSpaceCount = 0;
						for (int c = letters[line][letter].columns.size(); c > 1; c--) {
							if (letters[line][letter].condition.condition(r, c))
								break;
							leftSpaceCount++;
						}
						for (int c = 0; c < letters[line][letter + 1].columns.size(); c++) {
							if (letters[line][letter + 1].condition.condition(r, c))
								break;
							rightSpaceCount++;
						}
						letterDistances[r] = leftSpaceCount + rightSpaceCount;
					}
					int min = letterDistances[0];
					for (int i = 1; i < size; i++)
						min = Math.min(min, letterDistances[i]);
					if (min - size / 3 < 0)
						distances[line][letter + 1] =  min - size / 3 - 1;
					else
//						distances[line][letter + 1] = min - size / 3;
					distances[line][letter + 1] = min - size / 3 - 1;
				}
			}
		}

//		for (int i = 0; i < distances[0].length; i++)
//			System.out.print(distances[0][i] + " ");
//		System.out.println();
//		String text = "";
//		for (int line = 0; line < letters.length; line++) { //line
//			for (int row = 0; row < size; row++) { //row
//				for (int letter = 0; letter < letters[line].length; letter++) { //letter
////					int nextBold = 0;
//					for (int column = 0; column < letters[line][letter].columns.size() + boldIntensity; column++) { //column
//						if (letters[line][letter].condition.condition(row, column)) {
//							text += letters[line][letter].value;
////							if (bold)
////								nextBold = boldIntensity;
////							if (c == letters[ln][l].columns.size() - 1 && nextBold > 0)
////								while (nextBold > 0) {
////									text += letters[ln][l].name();
////									nextBold--;
////								}
//						}
//						else {
////						if (nextBold == 0)
//							text += ".";
////						else
////							while (nextBold > 0) {
////								text += letters[ln][l].name();
////								nextBold--;
////							}
//						}
//					}
////					text += space;
//				}
//				text += "\n";
////				if (italicized)
////					for (int i = 0; i <= row / 2; i++)
////						text += " ";
//			}
//			text += lineGap;
//		}

//		String text = "";
//		for (int line = 0; line < letters.length; line++) {
//			LetterCondition lineCondition = combineLetter(letters[line], distances[line], 0);
////			for (int l = 1; l < letters[line].length; l++)
////				lineCondition = (r, c) -> lineCondition.condition(r, c) || letters[line][l].condition.condition(r, c + letters[line][l - 1].columns.size() - letters[line][l].columns.size());
//			int lineLength = 0;
//			for (int i = 0; i < letters[line].length; i++) {
//				lineLength += letters[line][i].columns.size();
//				if (i < distances[line].length)
//					lineLength -= distances[line][i];
//			}
//			for (int row = 0; row < size; row++) {
//				for (int col = 0; col < lineLength; col++) {
//					if (lineCondition.condition(row, col))
//						text += "X";
//					else
//						text += ".";
//				}
//				text += "\n";
//			}
//			text += lineGap;
//		}
//		return text;
//	}
		String text = "";
		for (int line = 0; line < letters.length; line++) {
//			int lineLength = 0;
//			for (int i = 0; i < letters[line].length; i++) {
//				lineLength += letters[line][i].columns.size();
//				if (i < distances[line].length)
//					lineLength -= distances[line][i];
//			}
			for (int row = 0; row < size; row++) {
				for (int letter = 0; letter < letters[line].length - 1; letter++) {

					int shiftLeft = distances[line][letter];
					if (shiftLeft < 0)
						shiftLeft = 0;
					int shift = distances[line][letter + 1];
					if (shift < 0)
						shift = 0;
					for (int col = shiftLeft; col < letters[line][letter].columns.size() - shift; col++) {
						if (letters[line][letter].condition.condition(row, col))
							text += letters[line][letter].value;
						else
							text += " ";
					}
					if (shift == 0)
						for (int col = 0; col < - distances[line][letter + 1]; col++) {
							text += " ";
						}
					else
						for (int col = 0; col < distances[line][letter + 1]; col++) {
							if (letters[line][letter].condition.condition(row, col + letters[line][letter].columns.size() - distances[line][letter + 1]))
								text += letters[line][letter].value;
							else if (letters[line][letter + 1].condition.condition(row, col))
								text += letters[line][letter + 1].value;
							else
								text += " ";
						}
				}
				int shift = distances[line][letters[line].length - 1];
				if (shift < 0)
					shift = 0;
				int shiftLeft = distances[line][letters[line].length - 1];
				if (shiftLeft < 0)
					shiftLeft = 0;
				for (int col = 0; col < letters[line][letters[line].length - 1].columns.size() - shift; col++) {
					if (letters[line][letters[line].length - 1].condition.condition(row, col + shiftLeft))
						text += letters[line][letters[line].length - 1].value;
					else
						text += " ";
				}
//				int shiftLeft = distances[line][letter];
//				if (shiftLeft < 0)
//					shiftLeft = 0;
//				for (int col = shiftLeft; col < letters[line][letter].columns.size() - shift; col++) {
//					if (letters[line][letter].condition.condition(row, col))
//						text += letters[line][letter].value;
//					else
//						text += ".";
//				}

				text += "\n";
			}
			text += lineGap;
		}
		return text;
	}

//	public static LetterCondition combineLetter(Letter[] letters, int[] distances, int nextLetterStart) {
//		if (letters.length == 1)
//			return (r, c) -> letters[0].condition.condition(r, c + nextLetterStart);
//		Letter[] letters0 = new Letter[letters.length - 1];
//		for (int i = 0; i < letters0.length; i++)
//			letters0[i] = letters[i + 1];
//		int[] distances0 = new int[distances.length - 1];
//		for (int i = 0; i < distances0.length; i++)
//			distances0[i] = distances[i + 1];
//		return (r, c) -> letters[0].condition.condition(r, c + nextLetterStart)
//				|| combineLetter(letters0, distances0, nextLetterStart + letters[0].columns.size() - distances[0]).condition(r, c);
//	}
}
