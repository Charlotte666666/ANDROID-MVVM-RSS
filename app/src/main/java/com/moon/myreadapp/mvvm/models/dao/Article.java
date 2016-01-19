package com.moon.myreadapp.mvvm.models.dao;

import cn.bmob.v3.BmobObject;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "ARTICLE".
 */
public class Article extends BmobObject{



    public enum Status{
        NORMAL(0),
        FAVOR(1),
        NORMAL_AND_FAVOR(2),
        NORMAL_AND_FAVOR_BUT_UNREAD(3),
        DELETE(-2);

        public int status;

        Status(int s){ status = s;}

        public static Status find(int status){
            Status[] s = values();
            for (int i = 0;i < s.length;i++){
                if (status == s[i].status){
                    return s[i];
                }
            }
            return NORMAL;
        }
    }

    private Long id;
    /** Not-null value. */
    private String title;
    private Integer use_count;
    private String container;
    private String link;
    private String first_images;
    private java.util.Date publishtime;
    private java.util.Date last_read_time;
    private Integer status;
    private String uri;
    private String rights;
    private String creator;
    private long feed_id;
    private long user_id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ArticleDao myDao;

    private Feed feed;
    private Long feed__resolvedKey;

    private User user;
    private Long user__resolvedKey;


    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(Long id, String title, Integer use_count, String container, String link, String first_images, java.util.Date publishtime, java.util.Date last_read_time, Integer status, String uri, String rights, String creator, long feed_id, long user_id) {
        this.id = id;
        this.title = title;
        this.use_count = use_count;
        this.container = container;
        this.link = link;
        this.first_images = first_images;
        this.publishtime = publishtime;
        this.last_read_time = last_read_time;
        this.status = status;
        this.uri = uri;
        this.rights = rights;
        this.creator = creator;
        this.feed_id = feed_id;
        this.user_id = user_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getArticleDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getTitle() {
        return title;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUse_count() {
        return use_count;
    }

    public void setUse_count(Integer use_count) {
        this.use_count = use_count;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFirst_images() {
        return first_images;
    }

    public void setFirst_images(String first_images) {
        this.first_images = first_images;
    }

    public java.util.Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(java.util.Date publishtime) {
        this.publishtime = publishtime;
    }

    public java.util.Date getLast_read_time() {
        return last_read_time;
    }

    public void setLast_read_time(java.util.Date last_read_time) {
        this.last_read_time = last_read_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public long getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(long feed_id) {
        this.feed_id = feed_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    /** To-one relationship, resolved on first access. */
    public Feed getFeed() {
        long __key = this.feed_id;
        if (feed__resolvedKey == null || !feed__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FeedDao targetDao = daoSession.getFeedDao();
            Feed feedNew = targetDao.load(__key);
            synchronized (this) {
                feed = feedNew;
            	feed__resolvedKey = __key;
            }
        }
        return feed;
    }

    public void setFeed(Feed feed) {
        if (feed == null) {
            throw new DaoException("To-one property 'feed_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.feed = feed;
            feed_id = feed.getId();
            feed__resolvedKey = feed_id;
        }
    }

    /** To-one relationship, resolved on first access. */
    public User getUser() {
        long __key = this.user_id;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
            	user__resolvedKey = __key;
            }
        }
        return user;
    }

    public void setUser(User user) {
        if (user == null) {
            throw new DaoException("To-one property 'user_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            user_id = user.getId();
            user__resolvedKey = user_id;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
