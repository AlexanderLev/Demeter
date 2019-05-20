package pro.kbgame.demeter.common;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import pro.kbgame.demeter.repository.StatusKeeper;
import pro.kbgame.demeter.view.MainActivity;

public class LoaderStatus extends AsyncTaskLoader<MainActivity.StatusCallBack> {
    private MainActivity.StatusCallBack statusCallBack;

    public LoaderStatus(@NonNull Context context) {
        super(context);
        statusCallBack = StatusKeeper.getInstance();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public MainActivity.StatusCallBack loadInBackground() {
        return statusCallBack;
    }
}
