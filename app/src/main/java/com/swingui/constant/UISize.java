package com.swingui.constant;

/**
 * コンポーネントサイズ列挙型
 * 
 * @author t.yoshida
 */
public enum UISize
{
    /** できるだけ多くの領域を確保 */
    Infinite(Integer.MAX_VALUE);

    public final int length;

    private UISize(int length)
    {
        this.length = length;
    }
}
