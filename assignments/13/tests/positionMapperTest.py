import unittest
import sys
import os
sys.path.insert(0, os.path.abspath('..'))
from mapper.positionMapper import PositionMapper
from domain.position import Position

class PositionMapperTest(unittest.TestCase):
    def setUp(self):
        self.psMapper = PositionMapper()

    def testFind(self):
        rs = self.psMapper.find(1)
        self.assertIsInstance(rs,  Position)
        self.assertEqual(rs.position_id, 1)


if __name__ == "__main__":
    unittest.main()
