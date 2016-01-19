package com.moon.myreadapp.mvvm.models.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ARTICLE".
*/
public class ArticleDao extends AbstractDao<Article, Long> {

    public static final String TABLENAME = "ARTICLE";

    /**
     * Properties of entity Article.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Use_count = new Property(2, Integer.class, "use_count", false, "USE_COUNT");
        public final static Property Container = new Property(3, String.class, "container", false, "CONTAINER");
        public final static Property Link = new Property(4, String.class, "link", false, "LINK");
        public final static Property First_images = new Property(5, String.class, "first_images", false, "FIRST_IMAGES");
        public final static Property Publishtime = new Property(6, java.util.Date.class, "publishtime", false, "PUBLISHTIME");
        public final static Property Last_read_time = new Property(7, java.util.Date.class, "last_read_time", false, "LAST_READ_TIME");
        public final static Property Status = new Property(8, Integer.class, "status", false, "STATUS");
        public final static Property Uri = new Property(9, String.class, "uri", false, "URI");
        public final static Property Rights = new Property(10, String.class, "rights", false, "RIGHTS");
        public final static Property Creator = new Property(11, String.class, "creator", false, "CREATOR");
        public final static Property Feed_id = new Property(12, long.class, "feed_id", false, "FEED_ID");
        public final static Property User_id = new Property(13, long.class, "user_id", false, "USER_ID");
    };

    private DaoSession daoSession;


    public ArticleDao(DaoConfig config) {
        super(config);
    }
    
    public ArticleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ARTICLE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"TITLE\" TEXT NOT NULL ," + // 1: title
                "\"USE_COUNT\" INTEGER," + // 2: use_count
                "\"CONTAINER\" TEXT," + // 3: container
                "\"LINK\" TEXT," + // 4: link
                "\"FIRST_IMAGES\" TEXT," + // 5: first_images
                "\"PUBLISHTIME\" INTEGER," + // 6: publishtime
                "\"LAST_READ_TIME\" INTEGER," + // 7: last_read_time
                "\"STATUS\" INTEGER," + // 8: status
                "\"URI\" TEXT," + // 9: uri
                "\"RIGHTS\" TEXT," + // 10: rights
                "\"CREATOR\" TEXT," + // 11: creator
                "\"FEED_ID\" INTEGER NOT NULL ," + // 12: feed_id
                "\"USER_ID\" INTEGER NOT NULL );"); // 13: user_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ARTICLE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Article entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getTitle());
 
        Integer use_count = entity.getUse_count();
        if (use_count != null) {
            stmt.bindLong(3, use_count);
        }
 
        String container = entity.getContainer();
        if (container != null) {
            stmt.bindString(4, container);
        }
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(5, link);
        }
 
        String first_images = entity.getFirst_images();
        if (first_images != null) {
            stmt.bindString(6, first_images);
        }
 
        java.util.Date publishtime = entity.getPublishtime();
        if (publishtime != null) {
            stmt.bindLong(7, publishtime.getTime());
        }
 
        java.util.Date last_read_time = entity.getLast_read_time();
        if (last_read_time != null) {
            stmt.bindLong(8, last_read_time.getTime());
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(9, status);
        }
 
        String uri = entity.getUri();
        if (uri != null) {
            stmt.bindString(10, uri);
        }
 
        String rights = entity.getRights();
        if (rights != null) {
            stmt.bindString(11, rights);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(12, creator);
        }
        stmt.bindLong(13, entity.getFeed_id());
        stmt.bindLong(14, entity.getUser_id());
    }

    @Override
    protected void attachEntity(Article entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Article readEntity(Cursor cursor, int offset) {
        Article entity = new Article( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // use_count
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // container
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // link
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // first_images
            cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)), // publishtime
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // last_read_time
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // status
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // uri
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // rights
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // creator
            cursor.getLong(offset + 12), // feed_id
            cursor.getLong(offset + 13) // user_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Article entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.getString(offset + 1));
        entity.setUse_count(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setContainer(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLink(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setFirst_images(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPublishtime(cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)));
        entity.setLast_read_time(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setStatus(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setUri(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setRights(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setCreator(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setFeed_id(cursor.getLong(offset + 12));
        entity.setUser_id(cursor.getLong(offset + 13));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Article entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Article entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getFeedDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getUserDao().getAllColumns());
            builder.append(" FROM ARTICLE T");
            builder.append(" LEFT JOIN FEED T0 ON T.\"FEED_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN USER T1 ON T.\"USER_ID\"=T1.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Article loadCurrentDeep(Cursor cursor, boolean lock) {
        Article entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Feed feed = loadCurrentOther(daoSession.getFeedDao(), cursor, offset);
         if(feed != null) {
            entity.setFeed(feed);
        }
        offset += daoSession.getFeedDao().getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
         if(user != null) {
            entity.setUser(user);
        }

        return entity;    
    }

    public Article loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Article> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Article> list = new ArrayList<Article>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Article> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Article> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
