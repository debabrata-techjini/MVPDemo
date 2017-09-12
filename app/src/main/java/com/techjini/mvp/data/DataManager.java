package com.techjini.mvp.data;

import com.techjini.mvp.data.database.DatabaseManager;
import com.techjini.mvp.data.file.FileManager;
import com.techjini.mvp.data.network.ApiManager;
import com.techjini.mvp.data.preferences.PreferencesManager;

/**
 * It's an interface that is implemented by the AppDataManager. It contains methods, exposed for
 * all the data handling operations. It delegates the services provided by different data providers
 * - database, network and preferences. For this DataManager interface extends DatabaseManager,
 * ApiManager and PreferencesManager interfaces.
 *
 * @author Debu
 */
public interface DataManager extends DatabaseManager, ApiManager, PreferencesManager, FileManager {
}
