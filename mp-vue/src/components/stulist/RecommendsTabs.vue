<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="话题" name="first">话题</el-tab-pane>
    <el-tab-pane label="用户" name="second">
      <div>
        <el-col :span="18"><Scroll/></el-col>
        <el-col :span="6"><Sidetags/></el-col>
      </div>
    </el-tab-pane>
  </el-tabs>
</template>
<script>
  import Scroll from '@/components/stulist/Scroll'
  import Sidetags from '@/components/stulist/Sidetags'
  export default {
    name:'RecommendsTabs',
    data() {
      return {
        activeName: 'second'
      };
    },
    components:{
      Scroll,
      Sidetags
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };
</script>