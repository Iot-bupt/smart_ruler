package com.tjlcast.updateMessagePlugin.mapper;

import com.tjlcast.updateMessagePlugin.data.UpdateMessage;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface UpdateMessageMapper {
    @Insert("INSERT INTO update_message (message, messageType, ts, tenantId) VALUES (#{message}, #{messageType}, #{ts}, #{tenantId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addAMessage(UpdateMessage updateMessage);

    @Select("SELECT * FROM update_message")
    List<UpdateMessage> getAllMessage();

    @Select("SELECT * FROM update_message WHERE messageType = #{messageType}")
    List<UpdateMessage> getMessageByType(@Param("messageType") String messageType);

    @Select("SELECT * FROM update_message WHERE id = #{id}")
    UpdateMessage getMessageById(@Param("id") Integer id);

    @Delete("DELETE FROM update_message")
    void removeAllMessage();

    @Delete("DELETE FROM update_message WHERE id = #{id}")
    void removeMessageById(@Param("id") Integer id);

    @Select("SELECT * FROM update_message WHERE messageType = 'fromWeb' ORDER BY id DESC LIMIT 20")
    List<UpdateMessage> getFromWebMessage();

    @Select("SELECT * FROM update_message WHERE messageType = 'fromModule' ORDER BY id DESC LIMIT 20")
    List<UpdateMessage> getFromModuleMessage();

    @Select("SELECT * FROM update_message WHERE ts BETWEEN #{startTs} AND #{endTs}")
    List<UpdateMessage> getTsMessage(@Param("startTs") BigInteger startTs, @Param("endTs") BigInteger endTs);
}
