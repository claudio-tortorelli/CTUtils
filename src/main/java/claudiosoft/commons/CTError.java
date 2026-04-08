package claudiosoft.commons;

/**
 *
 * @author claudio.tortorelli
 */
public enum CTError {

    GENERIC_ERROR("0001"),
    INVALID_ARGUMENT("0002"),
    IO_GENERIC_ERROR("0003"),
    NETWORK_GENERIC_ERROR("0004"),
    FILESYSTEM_GENERIC_ERROR("0005"),
    UNDEFINED_VALUE("0006"),
    UNDEFINED_METHOD("0007"),
    INVALID_CMDLINE_SWITCH("0008"),
    INDEXER_GENERIC("0100"),
    INDEXER_UNSUPPORTED_MECHANISM("0101"),
    INDEXER_NOT_INIT("0102"),
    PLUGIN_GENERIC("0200"),
    PLUGIN_THREAD("0201"),
    PLUGIN_NOT_ENABLED("0202"),
    OLLAMA_GENERIC("0300"),
    TRANSIENT_GENERIC("0400"),
    TRANSIENT_READ_FILE("0401"),
    DB_GENERIC("0500"),
    DB_OPEN("0501"),
    DB_CONFIG("0502"),
    DB_INSERT("0503"),
    DB_DELETE("0504"),
    DB_SELECT("0505"),
    DB_UPDATE("0506"),
    DB_STATUS("0507"),
    DB_ACCESS("0509");

    private String code;

    private CTError(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }

}
