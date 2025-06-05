import React, { useState } from "react";
import { TextField, Button, Container, Typography, Box } from "@mui/material";
import axios from "axios";

const SignUp = () => {
  const [form, setForm] = useState({
    email: "",
    nickname: "",
    password: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("/api/members/register", form); // 백엔드 경로에 맞게 수정
      alert("회원가입 성공!");
    } catch (err) {
      console.error("에러:" + err);
      alert("회원가입 실패");
    }
  };

  return (
    <Container maxWidth="xs">
      <Box sx={{ mt: 8 }}>
        <Typography variant="h5" gutterBottom>
          회원가입
        </Typography>
        <form onSubmit={handleSubmit}>
          <TextField fullWidth label="이메일" name="email" margin="normal" value={form.email} onChange={handleChange} />
          <TextField
            fullWidth
            label="닉네임"
            name="nickname"
            margin="normal"
            value={form.nickname}
            onChange={handleChange}
          />
          <TextField
            fullWidth
            label="비밀번호"
            name="password"
            type="password"
            margin="normal"
            value={form.password}
            onChange={handleChange}
          />
          <Button type="submit" fullWidth variant="contained" sx={{ mt: 2 }}>
            회원가입
          </Button>
        </form>
      </Box>
    </Container>
  );
};

export default SignUp;
