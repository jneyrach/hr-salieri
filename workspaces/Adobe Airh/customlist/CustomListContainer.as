package customlist
{
    import mx.core.UIComponent;
    import flash.events.*;
    import flash.display.*;
    



    public class CustomListContainer extends UIComponent
    {
        private static const DEFAULT_HEIGHT :Number = 100;
        private static const DEFAULT_WIDTH :Number = 500;
        
	private var scroller:MovieClip;
	var padding:Number = 20;
	
    
        public function CustomListContainer()
        {
            super();
            
            var x:int = 5;
            var y:int = 5;


            var roundSquare:Shape = new Shape();

            roundSquare.graphics.lineStyle(0, 0x000099, 1, true);
            roundSquare.graphics.beginFill(0x0099CC);
            roundSquare.graphics.drawRoundRect(x, y, 250, 250, 10, 10);
            roundSquare.graphics.endFill();

            addChild(roundSquare);
            

            //var scroller:MovieClip = new MovieClip();
            scroller = new MovieClip();
            scroller.addEventListener(Event.ENTER_FRAME, moveScrollerThumbs);
        
        	
		for (var item:uint = 0; item < 20; item++ )  {
	
			var thisOne:MovieClip = new MovieClip();

			//outline
			var blackBox:Sprite = new Sprite();
			blackBox.graphics.beginFill(0x000000);
			blackBox.graphics.drawRect( -1, -1, 142, 107);
			thisOne.addChild(blackBox);
			thisOne.title = "Da Title";
			thisOne.link = "http://flashtuts.s3.amazonaws.com/073_CaurinaImageScroller/images/scottwills_cat.jpg";
			thisOne.src = "http://flashtuts.s3.amazonaws.com/073_CaurinaImageScroller/images/scottwills_cat.jpg";

			thisOne.x = (140 + 20) * item;
			thisOne.itemNum = item;

			scroller.addChild(thisOne);            
		}
            
            this.addChild(scroller);
	    scroller.y = 30;
        }
        
        
	function moveScrollerThumbs(e:Event):void {
	
		var speed:Number;
	
		if ( mouseY > scroller.y && mouseY < scroller.y + scroller.height) {//vertically over scroller
			if (mouseX < stage.stageWidth/2 - padding*2 && mouseX > 0) {//left of stage explicitly
				speed = -(mouseX - (stage.stageWidth/2 - padding*2)) / 8;
			}
			else if (mouseX > stage.stageWidth/2 + padding*2 && mouseX < stage.stageWidth) {//right of stage explicitly
				speed = -(mouseX - (stage.stageWidth/2 + padding*2)) / 8;
			}
			else {
				speed = 0;
			}
			scroller.x += speed;

			//scroller limits
			if (scroller.x < -scroller.width + stage.stageWidth - padding) { //if scrolled too far left
				scroller.x = -scroller.width + stage.stageWidth - padding;
			}
			else if (scroller.x > padding) { //if scrolled to far right
				scroller.x = padding;
			}
		}

	}

        override protected function createChildren():void
        {

            super.createChildren();
        }
    
        override protected function measure():void
        {

            super.measure();

            measuredMinHeight = measuredHeight = DEFAULT_HEIGHT;
            measuredMinWidth  = measuredWidth  = DEFAULT_WIDTH;
        }

        override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
        {

            super.updateDisplayList(unscaledWidth, unscaledHeight);
	}

    }
}
