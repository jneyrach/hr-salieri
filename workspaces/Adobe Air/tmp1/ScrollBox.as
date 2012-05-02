package
{
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.display.DisplayObject;
	import flash.display.Sprite;
	import flash.display.Shape;
	
	public class ScrollBox extends Sprite
	{
		
		private var _content:DisplayObject;
		private var _thumb:DisplayObject;
		private var _track:DisplayObject;
		private var _maxWidth:Number;
		private var _maxHeight:Number;
		private var _maxY:Number;
		private var _minY:Number = 0;
		private var _thumbOffset:Number;
		
		public function ScrollBox(pThumb:DisplayObject, pTrack:DisplayObject, pContent:DisplayObject)
		{
			_content = pContent;
			_thumb = pThumb;
			_track = pTrack;
			addEventListener(Event.ADDED_TO_STAGE, _stageHandler)
		}
		//--------------------------------------
		//  GETTERS & SETTERS
		//--------------------------------------
		public function get maxWidth():Number { return _maxWidth };
		public function set maxWidth(value:Number):void { _maxWidth = value };
		
		public function get maxHeight():Number { return _maxHeight };
		public function set maxHeight(value:Number):void { _maxHeight = value };
		
		//--------------------------------------
		//  EVENT HANDLERS
		//--------------------------------------
		
		private function _thumbMoveHanlder(pEvent:MouseEvent)
		{
			_thumb.y = mouseY - _thumbOffset;
			if(_thumb.y <= 0)
				_thumb.y = 0;
			if(_thumb.y >= _maxY)
				_thumb.y = _maxY;
			
			_content.y = Math.round(-(_thumb.y / _maxY) * (_content.height - _maxHeight));
			pEvent.updateAfterEvent();
		}
		
		private function _thumbMouseHandler(pEvent:MouseEvent):void
		{
			switch (pEvent.type) {
				case MouseEvent.MOUSE_DOWN:
					stage.addEventListener(MouseEvent.MOUSE_MOVE, _thumbMoveHanlder);
					_thumbOffset = mouseY - _thumb.y;
					break;
				case MouseEvent.MOUSE_UP:
					stage.removeEventListener(MouseEvent.MOUSE_MOVE, _thumbMoveHanlder);
					break;
			}
		}
		
		private function _stageHandler(pEvent:Event):void
		{
			switch (pEvent.type)
			{
				case Event.ADDED_TO_STAGE:
					removeEventListener(Event.ADDED_TO_STAGE, _stageHandler);
					_initialize();
					break;
				case Event.REMOVED_FROM_STAGE:
					_thumb.removeEventListener(MouseEvent.MOUSE_DOWN, _thumbMouseHandler)
					stage.removeEventListener(MouseEvent.MOUSE_UP, _thumbMouseHandler);
					removeEventListener(Event.REMOVED_FROM_STAGE, _stageHandler)
					break;
			}
		}
		
		//--------------------------------------
		//  PRIVATE & PROTECTED METHODS
		//--------------------------------------
		private function _initListeners():void
		{
			_thumb.addEventListener(MouseEvent.MOUSE_DOWN, _thumbMouseHandler)
			stage.addEventListener(MouseEvent.MOUSE_UP, _thumbMouseHandler);
			addEventListener(Event.REMOVED_FROM_STAGE, _stageHandler)
		}
		
		private function _createMask():Shape
		{
			var shape:Shape = new Shape();
			shape.graphics.beginFill(0x00FF00);
			shape.graphics.drawRect(0,0, _maxWidth, _maxHeight);
			shape.graphics.endFill();
			addChild(shape);
			return shape;
		}
		
		private function _initialize():void
		{
			_content.mask = _createMask();
			_content.x = _content.y = 0;
			
			_track.height = _maxHeight;
			_track.x = _thumb.x = _maxWidth - _track.width;
			_track.y = _thumb.y = 0;
			
			_thumb.height = Math.round( (_maxHeight / _content.height) * _track.height );
			_maxY = _track.height - _thumb.height;
			
			_initListeners();
		}
		
	}

}