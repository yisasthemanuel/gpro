var lang=[],uc_name={},uc_status={},uc_avatar={},uc_link={},barLinks=[],unfocus_chat=[],apps=[],Themes=[],blockList=[],Smiley=[];lang[0] = "Notifications";lang[1] = "Available";lang[2] = "Busy";lang[3] = "Invisible";lang[4] = "Chat";lang[5] = "Available to Chat";lang[6] = "Chat Sounds";lang[7] = "Chat (Offline)";lang[8] = "No friends are available to chat.";lang[9] = "You have no new notifications.";lang[10] = "Pop Out Chat";lang[11] = "Pop In Chat";lang[12] = "Search";lang[13] = "This user is offline. They will receive the message next login";lang[14] = "Hide Chat";lang[15] = "Show Chat";lang[16] = "Applications";lang[17] = "Keep List Open";lang[18] = "Show Names Only";lang[19] = "Chat Rooms";lang[20] = "Bookmarks";lang[21] = "See all notifications";lang[22] = "Status";lang[23] = "Options";lang[24] = "Clear Conversation";lang[25] = "Loading...";lang[26] = "No friends found.";lang[27] = "Chat is currently down for maintenance.";lang[28] = "close";lang[29] = "Theme:";lang[30] = "New message from";lang[31] = "Create";lang[32] = "Options";lang[33] = "Leave";lang[34] = "Loading...";lang[35] = " Online";lang[36] = "Keep Room Open";lang[37] = "Create a new chat room:";lang[38] = "Block Private Chats";lang[39] = "You must wait more time before creating another chatroom.";lang[40] = "User created chat rooms are currently disabled.";lang[41] = "Private Message";lang[42] = "Visit Profile";lang[43] = "Guest";lang[44] = "Moderator";lang[45] = "Administrator";lang[46] = "This user has private messaging disabled";lang[47] = "Stay in Room";lang[48] = "That chat room does not exist.";lang[49] = "The password entered was incorrect. Please try again.";lang[50] = "Enter the password for this chat room.";lang[51] = "Limit Reached: You must wait more time before sending another message.";lang[52] = "Make Moderator";lang[53] = "Ban User";lang[54] = "Remove Moderator";lang[55] = "You are banned from this chat room permanently.";lang[56] = "You are banned from this chat room for this many minutes: ";lang[57] = "Enter the number in minutes that the user should be banned for.  Enter 0 for a permanent ban.";lang[58] = "You must register or login to use chat.";lang[59] = "More &#9660;";lang[60] = "Start a Video Call";lang[61] = "I have sent you a video chat request. Ignore this message to decline.";lang[62] = "Accept";lang[63] = "Your video chat request has been sent.";lang[64] = "Other Applications";lang[65] = "Drag to reorder";lang[66] = "Send a File...";lang[67] = "cancel the upload";lang[68] = "Your file has been uploaded and sent.";lang[69] = "I have sent you a file. Ignore this message to decline.";lang[70] = "Download file";lang[71] = "second ago";lang[72] = "seconds ago";lang[73] = "minute ago";lang[74] = "minutes ago";lang[75] = "hour ago";lang[76] = "hours ago";lang[77] = "day ago";lang[78] = "days ago";lang[79] = "month ago";lang[80] = "months ago";lang[81] = "year ago";lang[82] = "years ago";lang[83] = "Guest";lang[84] = "Block User";lang[85] = "Would you also like to report this user?";lang[86] = "Browse";lang[87] = "Hit browse to upload a file or ";lang[88] = "Popout all chat conversations";lang[89] = "Close chat";lang[90] = "You";lang[91] = "Enter the name of the chat room you would like to create.";lang[92] = "Leave Chat Room";lang[93] = "Create a new chat room";lang[94] = "Change the chat theme";lang[95] = "Manage Block List...";lang[96] = "Select the user you wish to unblock";lang[97] = "Unblock";lang[98] = "Name";lang[99] = "Password (Optional)";lang[100] = "Join";lang[101] = "Chat Room Sounds";lang[102] = "Message not sent.  This user has blocked you.";lang[103] = "The user has been blocked. Messages by the user will no longer be received.";lang[104] = "Keep App Open";lang[105] = "Always Load App";lang[106] = " has been made a moderator by ";lang[107] = " has been kicked from the chat room by ";lang[108] = "Select the theme you wish to use";lang[109] = "Choose";lang[110] = "Mobile Chat";lang[111] = "Online Users";lang[112] = "Idle Users";lang[113] = "Back";lang[114] = "Send";lang[115] = "New";lang[116] = "You must login before using mobile chat";lang[117] = "Popout chat room";lang[118] = "Select";lang[119] = "Enter a name to chat with";lang[120] = "You must enter a name.";lang[121] = "The name can only consist of letters and numbers.";lang[122] = "There is a blocked word in your name: ";lang[123] = "You cannot change your name again.";lang[124] = "That name already exists.";lang[125] = "The name cannot be more than 25 characters.";Themes[0] = ['3', 'facebook_no_bar', 'facebook_no_bar'];Smiley[0] = ['smiley',':)'];Smiley[1] = ['smiley-mad','>:('];Smiley[2] = ['smiley-lol',':D'];Smiley[3] = ['smiley-wink','\;)'];Smiley[4] = ['smiley-surprise',':o'];Smiley[5] = ['smiley-cool','8)'];Smiley[6] = ['smiley-neutral',':|'];Smiley[7] = ['smiley-cry',':\'('];Smiley[8] = ['smiley-razz',':p'];Smiley[9] = ['smiley-confuse',':s'];Smiley[10] = ['smiley',':-)'];Smiley[11] = ['smiley-sad',':-('];Smiley[12] = ['smiley-wink','\;-)'];Smiley[13] = ['smiley-surprise',':-o'];Smiley[14] = ['smiley-cool','8-)'];Smiley[15] = ['smiley-neutral',':-|'];Smiley[16] = ['smiley-razz',':-p'];Smiley[17] = ['smiley-confuse',':-s'];Smiley[18] = ['smiley-sad',':('];var T=0,u_theme="facebook_no_bar",u_name="Jes&#250;s(A79)",u_id="113612",u_hide_bar="1",u_blist_open="0",u_sounds="1",u_chatroom_open="-1",u_chatroom_stay="-1",u_chatroom_block_chats="0",u_status="offline",u_no_avatars="0",u_hash_id="omfp9SNjNnvu7HEwtsn9",u_chat_open="0",u_chatroom_sound="1",u_apps_open="",u_logged_in="0",u_popout_time="99",u_avatar="https://gpro.s3.amazonaws.com/ManagerPics/113612.jpg",u_is_guest="0",u_guest_name="",c_chatrooms="0",c_chatroom_auto_join="0",c_guests_apps="1",c_video_chat="1",c_theme_change="0",c_notifications="0",c_chat_maintenance="0",c_guests_login_msg="0",c_search_min="10",c_us_time="1",c_file_transfer="0",c_width_blist="189",c_width_chatroom="16",c_width_apps="16",c_hide_bar_on="1",c_heart_beat="3",c_list_heart_beat="60",c_user_chatrooms="0",c_disable_avatars="0",c_disable_arrowchat="0",c_show_full_name="0",c_bar_fixed="0",c_bar_fixed_alignment="center",c_bar_fixed_width="900",c_bar_padding="15",c_applications_on="0",c_no_apps_menu="0",c_popout_on="1",c_push_engine="1",c_push_publish="pub-c-85312b36-d8b9-4e2d-95a0-4a68792d19be",c_push_subscribe="sub-c-d9c61bf6-c864-11e2-af25-02ee2ddab7fe",c_mobile_device="0",c_links_right="0",c_chat_animations="1",c_disable_smilies="",c_guest_name_change="1",k="/chat/fchat/";