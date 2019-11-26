<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="话题" name="first">
      <el-col :span="12" :offset="4"><Recommendtopic/></el-col>
    </el-tab-pane>
    <el-tab-pane label="用户" name="second">
      <div>{{test}}</div>
      <div>
        <el-col :span="12" :offset="4"><Recommenduser/></el-col>
        <el-col :span="4"><Sidetags/></el-col>
      </div>
    </el-tab-pane>
  </el-tabs>
</template>
<script>
  import Scroll from '@/components/stulist/Scroll'
  import Sidetags from '@/components/stulist/Sidetags'
  import Recommendtopic from '@/components/recommend/Recommendtopic'
  import Recommenduser from '@/components/recommend/Recommenduser'
  export default {
    name:'RecommendTabs',
    data() {
      return {
        activeName: 'second',
        test: this.$store.state.user
      };
    },
    components:{
      Scroll,
      Sidetags,
      Recommendtopic,
      Recommenduser,
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };
</script>