package services;

public interface JwtService {
    String getUsername(String token);
    boolean validate(String token);
}
