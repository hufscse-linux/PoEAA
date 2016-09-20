import unittest
import position

class deco_test(unittest.TestCase):
    def setUp(self):
        pass

    def test_get_cls_Position(self):
        position_obj = position.get_cls(position.Position, "Position", 1, "PositionId")
        self.assertEqual(1, position_obj.PositionId)
        

if __name__ == "__main__":
    unittest.main()
