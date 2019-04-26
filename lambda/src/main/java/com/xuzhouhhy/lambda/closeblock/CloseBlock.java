package com.xuzhouhhy.lambda.closeblock;

/**
 * created by hanhongyun on 2019/4/7 13:13
 */
public class CloseBlock {

    void testCloseBlock() {
        int initValue = 5;
        invokeCallBack(new CallBack() {
            @Override
            void onCallBack() {
                initValue = 6;
            }
        });
    }

    void testInCallBack() {
        String name = getAppendName(5, 6);
        invokeInCallBack(() -> {
            name = "han";
        });
    }

    private String getAppendName(int initValue, Integer reference) {
        return String.valueOf(initValue) + reference;
    }

    void invokeCallBack(CallBack callBack) {
        callBack.onCallBack();
    }

    void invokeInCallBack(InCallBack callBack) {
        callBack.onCallBack();
    }

}
