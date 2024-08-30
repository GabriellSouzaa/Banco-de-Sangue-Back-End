package banco.sangue.infrastructure.adapters.http.models.request;

import banco.sangue.domain.enums.UserRole;

public record RegisterRequest(String login, String password, UserRole role) {
}
