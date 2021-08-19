package ir.hsh.searchfoodtask.di.module

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.Module
import dagger.Provides
import ir.hsh.searchfoodtask.R
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class GlideModule() {

    @Singleton
    @Provides
    fun provideGlide(context: Context): RequestBuilder<Drawable> {
        return Glide.with(context)
            .asDrawable()
            .placeholder(R.drawable.place_holder)
            //.error(R.drawable.ic_launcher_foreground)
            .centerCrop()
            //.transform(CenterCrop(), CircleCrop())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
    }
}