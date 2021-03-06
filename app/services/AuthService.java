package services;

import model.User;
import play.libs.concurrent.HttpExecutionContext;

import javax.inject.Inject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Provides logic tied to authentication of users.
 */
public class AuthService {
	public static String SESSION_USER_ID_FIELD = "logged_user_id";
	public static String SESSION_USER_PROVIDER_ID_FIELD = "logged_user_provider_id";
	public static String SESSION_USER_NAME_FIELD = "logged_user_name";
	public static String SESSION_USER_ROLE_FIELD = "role";

	@Inject UserService userService;

	public CompletionStage<User> getLoggedUser(String userId) {
		CompletableFuture<User> loggedUserFuture = new CompletableFuture<>();

		if (userId == null) {
			loggedUserFuture.complete(null);
		} else {
			userService.getUserById(userId).thenApplyAsync(user -> loggedUserFuture.complete(user));
		}

		return loggedUserFuture;
	}
}
