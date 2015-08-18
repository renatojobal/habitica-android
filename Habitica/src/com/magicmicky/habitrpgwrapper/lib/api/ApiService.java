package com.magicmicky.habitrpgwrapper.lib.api;

import com.magicmicky.habitrpgwrapper.lib.models.ContentResult;
import com.magicmicky.habitrpgwrapper.lib.models.HabitRPGUser;
import com.magicmicky.habitrpgwrapper.lib.models.Status;
import com.magicmicky.habitrpgwrapper.lib.models.Tag;
import com.magicmicky.habitrpgwrapper.lib.models.TaskDirectionData;
import com.magicmicky.habitrpgwrapper.lib.models.UserAuth;
import com.magicmicky.habitrpgwrapper.lib.models.UserAuthResponse;
import com.magicmicky.habitrpgwrapper.lib.models.tasks.ItemData;
import com.magicmicky.habitrpgwrapper.lib.models.tasks.Task;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by MagicMicky on 10/06/2014.
 */
public interface ApiService {
    @GET("/status")
    void getStatus(Callback<Status> statusCallback);


    @GET("/user/")
    void getUser(Callback<HabitRPGUser> habitRPGUserCallback);

    @GET("/user/inventory/buy")
    void getInventoryBuyableGear(Callback<List<ItemData>> buyableGearCallback);

    @GET("/content")
    void getContent(Callback<ContentResult> contentResultCallback);

    @POST("/user/inventory/buy/{key}")
    void buyItem(@Path("key") String itemKey, Callback<Void> voidCallback);

   // @POST("/user/revive")
   // void revive(Callback<HabitRPGUser> habitRPGUserCallback);


    @GET("/user/tasks/{id}")
    void getTask(@Path("id") String id, Callback<Task> habitItemCallback);


    @POST("/user/tasks/{id}/{direction}")
    void postTaskDirection(@Path("id") String id, @Path("direction") String direction, Callback<TaskDirectionData> taskDirectionCallback);


    @POST("/user/tasks")
    void createItem(@Body Task item, Callback<Task> habitItemCallback);


    @PUT("/user/tasks/{id}")
    void updateTask(@Path("id") String id, @Body Task item, Callback<Task> habitItemCallback);


    @DELETE("/user/tasks/{id}")
    void deleteTask(@Path("id") String id, Callback<Void> voidCallback);


    @POST("/user/tags")
    void createTag(@Body Tag tag, Callback<List<Tag>> multiTagCallback);


    @PUT("/user/tags/{id}")
    void updateTag(@Path("id") String id, @Body Tag tag, Callback<Tag> multiTagCallback);


    @DELETE("/user/tags/{id}")
    void deleteTag(@Path("id") String id, Callback<Void> voidCallback);

    @POST("/user/auth/local")
    void connectLocal(@Body UserAuth auth, Callback<UserAuthResponse> callback);

    @POST("/user/sleep")
    void sleep(Callback<Void> voidCallback);

/*
    @GET("/content")
    void getContent();//Check Callback





    @POST("/user/inventory/sell/{type}/{key}")
    void sellItem(@Path("type") String type, @Path("key") String key);//Check callback

    @POST("/user/inventory/purchase/{type}/{key}")
    void purchaseItem(@Path("type") String type, @Path("key") String key);//Check callback

    @POST("/user/inventory/feed/{pet}/{food}")
    void feedPet(@Path("pet") String pet, @Path("food") String food);//Check Callback

    @POST("/user/inventory/equip/{type}/{key}")
    void equip(@Path("type") String type, @Path("key") String key);

    @POST("/user/inventory/hatch/{egg}/{hatchingPotion}")
    void hatch(@Path("egg") String egg, @Path("hatchingPotion") String potion);//Check Callback



*/
}
