<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="话题" name="first">话题</el-tab-pane>
    <el-tab-pane label="用户" name="second"><Scroll/></el-tab-pane>
  </el-tabs>
</template>
<script>
  import Scroll from '@/components/stulist/Scroll'
  export default {
    name:'Tabs',
    data() {
      return {
        activeName: 'second'
      };
    },
    components:{
      Scroll,
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };
</script>