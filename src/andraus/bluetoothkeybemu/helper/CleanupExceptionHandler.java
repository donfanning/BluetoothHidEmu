package andraus.bluetoothkeybemu.helper;

public class CleanupExceptionHandler implements Thread.UncaughtExceptionHandler {
    
    private BluetoothConnHelperInterface mConnHelper = null;
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler = null ;
    
    public CleanupExceptionHandler(BluetoothConnHelperInterface connHelper) {
        mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        mConnHelper = connHelper;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        if (mConnHelper != null) {
            mConnHelper.cleanup();
        }
        
        mDefaultExceptionHandler.uncaughtException(thread, ex);
    }
    
    

}