package claudiosoft.commons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.ini4j.Ini;
import org.ini4j.Wini;

/**
 *
 * @author claudio.tortorelli
 */
public class Config {

    private Wini ini;
    private boolean throwMissingExceptions;

    public Config(File configFile) throws FileNotFoundException, IOException {
        this(configFile, true);
    }

    public Config(File configFile, boolean throwMissingExceptions) throws FileNotFoundException, IOException {
        ini = new Wini();
        if (!configFile.exists()) {
            configFile.createNewFile();
        }
        ini.load(new FileReader(configFile));
        this.throwMissingExceptions = throwMissingExceptions;
    }

    public String get(String sectionName, String property) throws CTException {
        return get(sectionName, property, "");
    }

    public String get(String sectionName, String property, String defaultValue) throws CTException {
        Ini.Section section = ini.get(sectionName);
        if (section == null) {
            if (throwMissingExceptions) {
                throw new CTException("section undefined: " + sectionName, CTError.UNDEFINED_VALUE);
            } else {
                return defaultValue;
            }
        }
        String prop = section.get(property);
        if (prop == null) {
            prop = defaultValue;
        }
        return prop;
    }

    public int getInt(String sectionName, String property) throws CTException {
        return getInt(sectionName, property, "");
    }

    public int getInt(String sectionName, String property, String defaultValue) throws CTException {
        return Integer.parseInt(get(sectionName, property, defaultValue));
    }

}
