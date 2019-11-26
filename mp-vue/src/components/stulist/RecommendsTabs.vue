<template>
<<<<<<< HEAD
  <el-tabs v-model="activeName" @tab-click="handleClick" >
    <el-tab-pane label="话题" name="first">话题{{test}}</el-tab-pane>
=======
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="话题" name="first">
      <el-col :span="12" :offset="4"><Recommendtopic/></el-col>
      <el-col :span="4"><Sidetags/></el-col>
    </el-tab-pane>
>>>>>>> 52af531769f3bad8354e9c87254133eea403ee1e
    <el-tab-pane label="用户" name="second">
      <div>
        <el-col :span="18"> </el-col>
        <el-col :span="18"><Scroll/></el-col>
        <el-col :span="6"><Sidetags/></el-col>
      </div>
    </el-tab-pane>
  </el-tabs>
</template>
<script>
  import Scroll from '@/components/stulist/Scroll'
  import Sidetags from '@/components/stulist/Sidetags'
  import Recommendtopic from '@/components/recommend/Recommendtopic'
  export default {
    name:'RecommendTabs',
    data() {
      return {
        activeName: 'second',
        test: JSON.parse(window.localStorage.getItem('user' || '[]'))
      };
    },
    components:{
      Scroll,
      Sidetags,
      Recommendtopic
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };
</script>