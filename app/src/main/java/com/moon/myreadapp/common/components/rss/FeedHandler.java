package com.moon.myreadapp.common.components.rss;

import com.moon.myreadapp.mvvm.models.dao.Article;
import com.moon.myreadapp.mvvm.models.dao.Feed;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


/**
 * @description:
 * @author: Match
 * @date: 8/29/15
 */
public class FeedHandler extends DefaultHandler {
    /**
     * Constant for XML element name which identifies RSS items.
     */
    private static final String RSS_ITEM = "item";
    /**
     * Constant symbol table to ensure efficient treatment of handler states.
     */
    private final java.util.Map<String, Setter> setters;

    /**
     * Dispatcher to set either {@link #source} or {@link #item} fields.
     */
    private Setter setter;

    /**
     * Interface to store information about RSS elements.
     */
    private static interface Setter {}

    /**
     * Closure to change fields in POJOs which store RSS content.
     */
    private static interface ContentSetter extends Setter {

        /**
         * Set the field of an object which represents an RSS element.
         */
        void set(String value);

    }

    /**
     * Closure to change fields in POJOs which store information
     * about RSS elements which have only attributes.
     */
    private static interface AttributeSetter extends Setter {

        /**
         * Set the XML attributes.
         */
        void set(Attributes attributes);

    }

    /**
     * Setter for RSS &lt;title&gt; elements inside a &lt;channel&gt; or an
     * &lt;item&gt; element. The title of the RSS feed is set only if
     * {@link #item} is {@code null}. Otherwise, the title of the RSS
     * {@link #item} is set.
     */
    private final Setter SET_TITLE = new ContentSetter() {
        @Override
        public void set(String title) {
            if (item == null) {
                source.setTitle(title);
            } else {
                item.setTitle(title);
            }
        }
    };

    /**
     * Setter for RSS &lt;description&gt; elements inside a &lt;channel&gt; or an
     * &lt;item&gt; element. The title of the RSS feed is set only if
     * {@link #item} is {@code null}. Otherwise, the title of the RSS
     * {@link #item} is set.
     */
    private final Setter SET_DESCRIPTION = new ContentSetter() {
        @Override
        public void set(String description) {
            if (item == null) {
                //source.setDescription(description);
            } else {
                //item.setContainer(description);
            }
        }
    };

    /**
     * Setter for an RSS &lt;content:encoded&gt; element inside an &lt;item&gt;
     * element.
     */
    private final Setter SET_CONTENT = new ContentSetter() {
        @Override
        public void set(String content) {
            if (item != null) {
                item.setContainer(content);
            }
        }
    };

    /**
     * Setter for RSS &lt;link&gt; elements inside a &lt;channel&gt; or an
     * &lt;item&gt; element. The title of the RSS feed is set only if
     * {@link #item} is {@code null}. Otherwise, the title of the RSS
     * {@link #item} is set.
     */
    private final Setter SET_LINK = new ContentSetter() {
        @Override
        public void set(String link) {
            if (link.endsWith("/")) {
                link = link.substring(0, link.length() - 1);
            }
            if (item != null) {
                item.setLink(link);
            } else {
                source.setLink(link);
                source.setIcon(link + "/favicon.ico");
            }
        }
    };

    /**
     * Setter for RSS &lt;pubDate&gt; elements inside a &lt;channel&gt; or an
     * &lt;item&gt; element. The title of the RSS feed is set only if
     * {@link #item} is {@code null}. Otherwise, the title of the RSS
     * {@link #item} is set.
     */
    private final Setter SET_PUBDATE = new ContentSetter() {
        @Override
        public void set(String pubDate) {
            final java.util.Date date = DateUtil.parseRfc822(pubDate);
            if (item == null) {
                source.setPublishtime(date);
            } else {
                item.setPublishtime(date);
            }
        }
    };

    private Feed source;

    /**
     * Reference is {@code null} unless started to parse &lt;item&gt; element.
     * Visibility must be package-private to ensure efficiency of inner classes.
     */
    Article item;
    List<Article> articles;

    /**
     * If not {@code null}, then buffer the characters inside an XML text element.
     */
    private StringBuilder buffer;

    FeedHandler() {
        source = new Feed();
        articles = new ArrayList<Article>();
        //source.seta(new ArrayList<FeedItem>());
        // initialize dispatchers to manage the state of the SAX handler
        setters = new java.util.HashMap<String, Setter>(/* 2^3 */16);
        setters.put("title", SET_TITLE);
        setters.put("description", SET_DESCRIPTION);
        setters.put("content:encoded", SET_CONTENT);
        setters.put("link", SET_LINK);
        setters.put("pubDate", SET_PUBDATE);

        // TODO: 8/29/15 parse other useful
//        setters.put("category", ADD_CATEGORY);
//        setters.put("media:thumbnail", ADD_MEDIA_THUMBNAIL);
//        setters.put("lastBuildDate", SET_LAST_BUILE_DATE);
//        setters.put("ttl", SET_TTL);
//        setters.put("enclosure", SET_ENCLOSURE);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Lookup dispatcher in hash table
        setter = setters.get(qName);
        if (setter == null) {
            if (RSS_ITEM.equals(qName)) {
                item = new Article();
            }
        } else if (setter instanceof AttributeSetter) {
            ((AttributeSetter) setter).set(attributes);
        } else {
            buffer = new StringBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isBuffering()) {
            // set field of an feed source or feed item
            ((ContentSetter) setter).set(buffer.toString());

            // clear buffer
            buffer = null;
        } else if (RSS_ITEM.equals(qName)) {
            articles.add(item);

            // (re)enter <channel> scope
            item = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isBuffering()) {
            buffer.append(ch, start, length);
        }
    }

    /**
     * Determines if the SAX parser is ready to receive data inside an XML element
     * such as &lt;title&gt; or &lt;description&gt;.
     *
     * @return boolean {@code true} if the SAX handler parses data inside an XML
     *         element, {@code false} otherwise
     */
    boolean isBuffering() {
        return buffer != null && setter != null;
    }

    Feed getFeedSource() {
        source.setArticles(articles);
        return source;
    }
}
