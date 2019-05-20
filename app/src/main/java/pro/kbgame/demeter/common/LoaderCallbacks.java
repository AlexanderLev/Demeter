package pro.kbgame.demeter.common;

import android.os.Bundle;

import androidx.loader.content.Loader;

public interface LoaderCallbacks <D> {
    public Loader<D> onCreateLoader(int id, Bundle args);
    public void onLoadFinished(Loader<D> loader, D data);
    public void onLoaderReset(Loader<D> loader);
}
