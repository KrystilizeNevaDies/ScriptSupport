package cuberite.plugin;

import org.luaj.vm2.LuaValue;

import net.minestom.server.chat.ChatColor;
import net.minestom.server.chat.ColoredText;

public class TextType {
	public static final TextType ERROR = new TextType(ChatColor.UNDERLINED, "[ERROR] ");
	public static final TextType INFO = new TextType(ChatColor.YELLOW, "[INFO] ");
	public static final TextType FATAL = new TextType(ChatColor.RED, "[FATAL] ");
	public static final TextType FAILURE = new TextType(ChatColor.RED, "[INFO] ");
	public static final TextType SUCCESS = new TextType(ChatColor.BRIGHT_GREEN, "[INFO] ");
	public static final TextType WARNING = new TextType(ChatColor.RED, "[WARN] ");
	public static final TextType SYSTEM = new TextType(ChatColor.BOLD, "[SYSTEM] ");
	
	private String prefix;
	private ChatColor color;
	
	private TextType(ChatColor someColor, String string) {
		prefix = string;
		color = someColor;
	}
	
	public ColoredText create(String string) {
		return ColoredText.of(color, prefix.concat(string));
	}
	
	public ColoredText create(LuaValue string) {
		return create(string.tojstring());
	}
}