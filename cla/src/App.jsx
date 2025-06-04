import { useEffect, useRef, useState } from "react";
import ChatRoom from "./components/websocket";
import VoiceChat from "./components/test/VoiceChat";
import VoiceChattest from "./components/test/VoiceChattest";
import VoiceChattest2 from "./components/test/VoiceChattest2";
import VoiceChannel from "./components/test/VoiceChannelTest";
import VoiceChannelTest from "./components/test/VoiceChannelTest";
import VoiceChannelWithSpeaking from "./components/test/VoiceChannelWithSpeaking";

function App({ postId }) {
  return (
    <div>
      <h2>게시글 채팅방</h2>
      {/* <ChatRoom postId={123} />; */}
      {/* <VoiceChat roomId="123" /> */}
      {/* <VoiceChattest roomId="123" /> */}
      {/* <VoiceChattest2 roomId="123" /> */}
      {/* <VoiceChannelTest /> */}
      <VoiceChannelWithSpeaking />
    </div>
  );
}

export default App;
