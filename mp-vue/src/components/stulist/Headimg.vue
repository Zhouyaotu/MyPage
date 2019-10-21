<template>
  <el-col>
    <div class="demo-basic--circle">
      <div class="block"><el-avatar :size="70" :src="circleUrl"></el-avatar></div>
    </div>
  </el-col>  
</template>
<script>
  export default {
    name:'Headimg',
    data () {  
      return {
        circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
        sizeList: ["large", "medium", "small"]
      }
    }
  }
</script>