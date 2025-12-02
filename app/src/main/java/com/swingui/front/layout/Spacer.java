package com.swingui.front.layout;

import java.awt.Dimension;

import com.swingui.constant.UISize;
import com.swingui.widget.PanelWT;

/**
 * スペーサー部品提供クラス
 * 
 * @author t.yoshida
 */
public class Spacer
{
    /**
     * 指定したサイズのスペース領域を確保する。
     * 
     * @param width 幅
     * @param height 高さ
     * @return {@code PanelWT}
     */
    public static PanelWT of(int width, int height)
    {
        if(isInfinite(width) || isInfinite(height))
        {
            // 幅または高さが最大限の場合、柔軟なスペース領域を確保
            return flexible(new Dimension(width, height));
        }
        else
        {
            // 幅・高さが固定値の場合、固定のスペース領域を確保
            return fixed(new Dimension(width, height));
        }
    }

    /**
     * 指定したサイズのスペース領域を確保する。
     *
     * @param width 幅
     * @param height 高さ
     * @return {@code PanelWT}
     */
    public static PanelWT of(UISize width, int height)
    {
        return of(width.length, height);
    }

    /**
     * 指定したサイズのスペース領域を確保する。
     *
     * @param width 幅
     * @param height 高さ
     * @return {@code PanelWT}
     */
    public static PanelWT of(int width, UISize height)
    {
        return of(width, height.length);
    }

    /**
     * 指定した幅/高さが {@link UISize#Infinite} かどうかを判定する。
     * 
     * @param length 幅または高さ
     * @return {@code true}: 無限大、{@code false}: それ以外
     */
    private static boolean isInfinite(int length)
    {
        return length == UISize.Infinite.length;
    }

    /**
     * レイアウトマネージャの制限内で最大限のスペース領域を確保する。
     * 
     * @return {@code PanelWT}
     */
    public static PanelWT fill()
    {
        return flexible(new Dimension(UISize.Infinite.length, UISize.Infinite.length));
    }

    /**
     * 指定した幅のスペースを確保する。
     * 
     * @param width 幅
     * @return {@code PanelWT}
     */
    public static PanelWT widthOnly(UISize width)
    {
        return of(width.length, 0);
    }

    /**
     * 指定した幅のスペースを確保する。
     * 
     * @param width 幅
     * @return {@code PanelWT}
     */
    public static PanelWT widthOnly(int width)
    {
        return of(width, 0);
    }

    /**
     * 指定した高さのスペースを確保する。
     * 
     * @param height 高さ
     * @return {@code PanelWT}
     */
    public static PanelWT heightOnly(UISize height)
    {
        return of(0, height.length);
    }

    /**
     * 指定した高さのスペースを確保する。
     * 
     * @param height 高さ
     * @return {@code PanelWT}
     */
    public static PanelWT heightOnly(int height)
    {
        return of(0, height);
    }

    /**
     * 指定したサイズで柔軟なスペース領域を確保する。
     * 
     * @param dimension サイズ
     * @return {@code PanelWT}
     */
    private static PanelWT flexible(Dimension dimension)
    {
        //
        // レイアウトに応じて PanelWT を拡縮させる場合、
        // PanelWT#setPreferredSize() は設定しない。
        //
        PanelWT panel = new PanelWT();
        panel.setMinimumSize(new Dimension(0, 0));
        panel.setMaximumSize(dimension);

        return panel;
    }

    /**
     * 指定したサイズで固定のスペース領域を確保する。
     * 
     * @param dimension サイズ
     * @return {@code PanelWT}
     */
    private static PanelWT fixed(Dimension dimension)
    {
        //
        // サイズ固定の PanelWT を生成する場合、
        // PanelWT#setPreferredSize() を含めて設定する。
        //
        PanelWT panel = new PanelWT();
        panel.setPreferredSize(dimension);
        panel.setMinimumSize(dimension);
        panel.setMaximumSize(dimension);

        return panel;
    }
}
