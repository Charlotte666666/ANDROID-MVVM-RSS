package com.moon.myreadapp.common.components.rss;

/**
 * @description:
 * @author: Match
 * @date: 8/29/15
 */
public class FeedReadException extends Exception {

    public FeedReadException(int status, String message) {
        super(message);
    }
}
