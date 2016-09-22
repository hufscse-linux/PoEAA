import unittest
import mapper
import position

class deco_test(unittest.TestCase):
    def setUp(self):
        pass

    def test_get_cls_Position(self):
        position_obj = mapper.get_cls(position.Position, "Position", 1, "PositionId")
        self.assertEqual(1, position_obj.PositionId)
        self.assertEqual('boss', position_obj.Title)
        

if __name__ == "__main__":
    unittest.main()
