package com.xcz.baselib.utils.image;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.xcz.baselib.R;
import com.xcz.baselib.weight.CircleTransform;

/**
 * 图片加载工具类
 * Created by xcz
 * on 2018/5/15.
 */
public class ImageUtils {
    /**
     * 加载图片
     */
    public static void loadImgByPicasso(Context context, String path, ImageView target) {
        if (target == null) {
            return;
        }
        if (path != null && path.length() > 0) {
            Picasso.get()
                    .load(path)
                    .into(target);
        }
    }

    /**
     * 加载图片
     */
    public static void loadImgByPicasso(Context context, int path, ImageView target) {
        if (target == null) {
            return;
        }
        if (path != 0) {
            Picasso.get()
                    .load(path)
                    .placeholder(path)
                    .into(target);
        }
    }


    /**
     * 加载本地图片
     *
     * @param context 上下文
     * @param path    路径
     * @param target  view
     */
    public static void loadImgByPicassoWithCircle(Context context, int path, ImageView target) {
        if (target == null) {
            return;
        }
        if (path > 0) {
            Picasso.get()
                    .load(path)
                    .placeholder(R.drawable.image_default)
                    .transform(new CircleTransform())
                    .into(target);
        }
    }


    /**
     * 加载人物，机构logo时，加载失败时显示默认图片
     *
     * @param path   路径
     * @param resId  加载失败时，默认图片
     * @param target 控件
     */
    public static void loadImgByPicassoPerson(Context context, String path, int resId, ImageView target) {
        if (target == null) {
            return;
        }
        if (path != null && path.length() > 0) {
            Picasso.get()
                    .load(path)
                    .error(resId)
                    .placeholder(resId)
                    .transform(new CircleTransform())
                    .into(target);
        }
    }

    /**
     * 加载图片
     *
     * @param resId  string
     * @param target 控件
     */
    public static void loadImgByPicasso(Context context, String path, int resId, ImageView target) {
        if (target == null) {
            return;
        }
        if (path != null && path.length() > 0) {
            Picasso.get()
                    .load(path)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        } else {
            Picasso.get()
                    .load(resId)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        }
    }

    /**
     * 加载图片
     *
     * @param resId  string
     * @param target 控件
     */
    public static void loadImgByPicasso(Context context, String path, int resId,
                                        ImageView target, Callback callback) {
        if (target == null) {
            return;
        }
        if (path != null && path.length() > 0) {
            Picasso.get()
                    .load(path)
                    .placeholder(resId)
                    .error(resId)
                    .into(target, callback);
        } else {
            Picasso.get()
                    .load(resId)
                    .placeholder(resId)
                    .error(resId)
                    .into(target, callback);
        }
    }


    /**
     * 加载图片
     *
     * @param resId  int
     * @param target 控件
     */
    public static void loadImgByPicasso(Context context, int path, int resId, ImageView target) {
        if (target == null) {
            return;
        }
        if (path > 0) {
            Picasso.get()
                    .load(path)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        } else {
            Picasso.get()
                    .load(resId)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        }
    }


    /**------------------------------Glide加载图片--------------------------------------------------**/


    /**
     * 将gif图转换为静态图
     *
     * @param context
     * @param url
     * @param resId
     * @param imageView
     */
    public static void displayGif(Context context, String url, int resId, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        if (url != null && url.length() > 0) {
            GlideApp.with(context)
                    .load(url)
                    .placeholder(resId)
                    .error(resId)
                    .into(imageView);
        } else {
            GlideApp.with(context)
                    .load(resId)
                    .placeholder(resId)
                    .error(resId)
                    .into(imageView);
        }
    }


    /**
     * 加载带有圆角的矩形图片  用glide处理
     *
     * @param path   路径
     * @param round  圆角半径
     * @param resId  加载失败时的图片
     * @param target 控件
     */
    public static void loadImgByGlideWithRound(final Context activity, String path, final int round, int resId, final ImageView target) {
//        if (path != null && path.length() > 0) {
//            GlideApp.with(activity)
//                    .load(path)
//                    .placeholder(resId)
//                    .error(resId)
//                    //设置缓存
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(new BitmapImageViewTarget(target) {
//                        @Override
//                        protected void setResource(Bitmap resource) {
//                            super.setResource(resource);
//                            RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(activity.getResources(), resource);
//                            //设置圆角弧度
//                            circularBitmapDrawable.setCornerRadius(round);
//                            target.setImageDrawable(circularBitmapDrawable);
//                        }
//                    });
//        }
    }
}
