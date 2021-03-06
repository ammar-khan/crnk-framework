package io.crnk.core.engine.error.handlers;

import io.crnk.core.engine.document.ErrorData;
import io.crnk.core.engine.error.ErrorResponse;
import io.crnk.core.engine.error.ErrorResponseBuilder;
import io.crnk.legacy.queryParams.errorhandling.ExceptionMapperProvider;

/**
 * Created by yuval on 02/03/2017.
 */
@ExceptionMapperProvider
public class SubclassExceptionMapper extends BaseExceptionMapper<IllegalArgumentException> {

	@Override
	public ErrorResponse toErrorResponse(IllegalArgumentException exception) {
		return new ErrorResponseBuilder()
				.setStatus(500)
				.setSingleErrorData(ErrorData.builder()
						.setTitle("byebye")
						.build())
				.build();
	}
}
