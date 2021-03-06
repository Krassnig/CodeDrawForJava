package codedraw.textformat;

import java.awt.*;
import java.util.*;

/**
 * The TextFormat class can be used to specify how CodeDraw formats, places and styles it's drawn text.
 */
public final class TextFormat {
	private static final Set<String> availableFonts = new HashSet<>(Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));

	public TextFormat() { }

	private HorizontalAlign horizontalAlign = HorizontalAlign.LEFT;
	public HorizontalAlign getHorizontalAlign() { return horizontalAlign; }
	public void setHorizontalAlign(HorizontalAlign horizontalAlign) {
		if (horizontalAlign == null) throw createArgumentNull("horizontalAlign");
		this.horizontalAlign = horizontalAlign;
	}

	private VerticalAlign verticalAlign = VerticalAlign.TOP;
	public VerticalAlign getVerticalAlign() { return verticalAlign; }
	public void setVerticalAlign(VerticalAlign verticalAlign) {
		if (horizontalAlign == null) throw createArgumentNull("verticalAlign");
		this.verticalAlign = verticalAlign;
	}

	private int fontSize = 16;
	public int getFontSize() { return fontSize; }
	public void setFontSize(int fontSize) {
		if (fontSize < 1) throw createArgumentNotNegative("fontSize");
		this.fontSize = fontSize;
	}

	private String fontName = "Arial";
	public String getFontName() { return fontName; }
	public void setFontName(String fontName) {
		if (fontName == null) throw createArgumentNull("fontName");
		if (!availableFonts.contains(fontName))
			throw new IllegalArgumentException("Font with the name " + fontName + " is not available");
		this.fontName = fontName;
	}

	private boolean bold = false;
	public boolean getBold() { return bold; }
	public void setBold(boolean isBold) {
		this.bold = isBold;
	}

	private boolean italic = false;
	public boolean getItalic() { return italic; }
	public void setItalic(boolean isItalic) { this.italic = isItalic; }

	private Underline underline = Underline.NONE;
	public Underline getUnderline() { return underline; }
	public void setUnderlined(Underline underline) {
		if (underline == null) throw createArgumentNull("underline");
		this.underline = underline;
	}

	private boolean strikethrough = false;
	public boolean getStrikethrough() { return strikethrough; }
	public void setStrikethrough(boolean strikethrough) {
		this.strikethrough = strikethrough;
	}


	private static IllegalArgumentException createArgumentNull(String argumentName) {
		return new IllegalArgumentException("The parameter " + argumentName + " cannot be null.");
	}

	private static IllegalArgumentException createArgumentNotNegative(String argumentName) {
		return new IllegalArgumentException("Argument " + argumentName + " cannot be negative.");
	}
}
