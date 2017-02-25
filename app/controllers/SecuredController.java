package controllers;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import services.AuthService;

/**
 * Created by martin on 2/25/17.
 */
public class SecuredController extends Security.Authenticator {

	@Override
	public String getUsername(Http.Context ctx) {
		return ctx.session().get(AuthService.SESSION_USER_NAME_FIELD);
	}

	@Override
	public Result onUnauthorized(Http.Context ctx) {
		return super.onUnauthorized(ctx);
	}
}
