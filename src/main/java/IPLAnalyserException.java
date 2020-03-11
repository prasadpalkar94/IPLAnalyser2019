public class IPLAnalyserException extends RuntimeException{
    enum ExceptionType {
        IPL_FILE_PROBLEM,UNABLE_TO_PARSE,UnsupportedFileFormat, IPL_DATA_PROBLEM,INVALID_CHOICE
    }

    ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
