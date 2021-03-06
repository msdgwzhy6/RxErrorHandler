package me.jessyan.rxerrorhandler.core;

import android.content.Context;

import me.jessyan.rxerrorhandler.handler.ErrorHandlerFactory;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErroListener;

/**
 * Created by jess on 9/2/16 13:27
 * Contact with jess.yan.effort@gmail.com
 */
public class RxErrorHandler {
    public final String TAG = this.getClass().getSimpleName();
    private ErrorHandlerFactory mHandlerFactory;

    private RxErrorHandler(Builder builder) {
        this.mHandlerFactory = builder.errorHandlerFactory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ErrorHandlerFactory getHandlerFactory() {
        return mHandlerFactory;
    }

    public static final class Builder {
        private Context context;
        private ResponseErroListener responseErroListener;
        private ErrorHandlerFactory errorHandlerFactory;

        private Builder() {
        }

        public Builder with(Context context) {
            this.context = context;
            return this;
        }

        public Builder responseErroListener(ResponseErroListener responseErroListener) {
            this.responseErroListener = responseErroListener;
            return this;
        }

        public RxErrorHandler build() {
            if (context == null)
                throw new IllegalStateException("context is required");

            if (responseErroListener == null)
                throw new IllegalStateException("responseErroListener is required");

            this.errorHandlerFactory = new ErrorHandlerFactory(context, responseErroListener);

            return new RxErrorHandler(this);
        }
    }


}
