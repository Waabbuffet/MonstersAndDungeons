package com.waabbuffet.MonstersAndDungeons.packet;

import com.waabbuffet.MonstersAndDungeons.entity.MaDEntityMonsterBase;
import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityAutomatonsRook;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class UpdateClientEntityAnimation implements IMessage, IMessageHandler<UpdateClientEntityAnimation , IMessage> {

	int id, animationID;

	public UpdateClientEntityAnimation(){ }



	public UpdateClientEntityAnimation(MaDEntityMonsterBase entity, int whichAnimation)
	{
		id = entity.getEntityId();
		this.animationID = whichAnimation;
	}

	@Override
	public IMessage onMessage(final UpdateClientEntityAnimation message, MessageContext ctx) {

		IThreadListener mainThread = Minecraft.getMinecraft(); // or Minecraft.getMinecraft() on the client
		mainThread.addScheduledTask(new Runnable() {

			@Override
			public void run() {
				EntityPlayer p = Minecraft.getMinecraft().thePlayer;
				World world = p.worldObj;

				EntityAutomatonsRook rook = (EntityAutomatonsRook) world.getEntityByID(message.id);

				if(rook != null)
				{
					rook.acivateAnimationby(message.animationID);
				}
			}
		});


		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.id = buf.readInt();
		this.animationID = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
		buf.writeInt(animationID);
	}
}