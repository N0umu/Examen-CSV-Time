public interface ITimeService {
    void setNext(ITimeService next);
    void handleRequest(TimeRequest request, int value);
}